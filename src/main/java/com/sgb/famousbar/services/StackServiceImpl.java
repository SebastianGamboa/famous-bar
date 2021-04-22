package com.sgb.famousbar.services;

import java.util.ArrayList;
import java.util.List;

import com.sgb.famousbar.entities.Stack;
import com.sgb.famousbar.entities.StackDTO;
import com.sgb.famousbar.repositories.StackRepository;
import com.sgb.famousbar.shared.ResponseArray;
import com.sgb.famousbar.utils.Converter;
import com.sgb.famousbar.utils.exceptions.ResourceNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class StackServiceImpl implements StackService {

    private final StackRepository stackRepository;

    public StackServiceImpl(StackRepository stackRepository) {
        this.stackRepository = stackRepository;
    }

    private StackDTO findById(int id) throws ResourceNotFoundException  {
        return this.stackRepository.findById((long) id)
            .map(this::convertToStackDTO)
            .orElseThrow(() -> new ResourceNotFoundException("Stack", "id", id));
    }

    private StackDTO convertToStackDTO(Stack stack) {
        StackDTO stackDTO = new StackDTO();
        stackDTO.setId(stack.getId());
        stackDTO.setInputArray(stack.getInputArray());
        return stackDTO;
    }

    private List<Integer> generatePrimeNumbers(int iterations) {
        int countPrimeNumbers = 1;
        int count = 2;
        List<Integer> primeNumbers = new ArrayList<>();
        while (countPrimeNumbers <= iterations) {
            if (isPrime(count)) {
                primeNumbers.add(count);
                countPrimeNumbers++;
            }
            count++;
        }
        return primeNumbers;
    }

    private boolean isPrime(int number) {
        double sqrtResult = Math.sqrt(number);
        for(int i = 2; i <= sqrtResult; i++)
            if(number % i == 0) return false; 
        return number >= 2;
    }

    @Override
    public ResponseArray generateArray(int iterations, int stackId) {
        List<Integer> primeNumbers = generatePrimeNumbers(iterations);
        List<Integer> Ai = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> Result = new ArrayList<>();
        StackDTO stackDTO = findById(stackId);
        if (stackDTO != null) {
            List<Integer> A = Converter.stringToArray(stackDTO.getInputArray());
            for (int i = 0; i < iterations; i++) {
                int sizeA = A.size();
                for(int j = sizeA - 1; j >= 0; j--) {
                    if (A.get(j) % primeNumbers.get(i) == 0)
                        B.add(A.get(j));
                    else
                        Ai.add(A.get(j));
                }
                A.clear();
                A.addAll(Ai);
                Result.addAll(B);
                Ai.clear();
                B.clear();
            }
            if (A.size() > 0)
                Result.addAll(A);
            return new ResponseArray(Result.stream().mapToInt(Integer::valueOf).toArray());
        } else {
            throw new RuntimeException("Something went wrong");
        }
    }    
}
