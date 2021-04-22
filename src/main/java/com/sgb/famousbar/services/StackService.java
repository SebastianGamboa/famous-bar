package com.sgb.famousbar.services;

import com.sgb.famousbar.shared.ResponseArray;

public interface StackService {

    /**
     * Generate array with numbers of the glasses
     * @param iterations
     * @param stackId
     * @return the response array
     */
    public ResponseArray generateArray(int iterations, int stackId);
}
