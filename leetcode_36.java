package com.company;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> hashSet = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (hashSet.contains(board[i][j]) && board[i][j] != '.')
                    return false;
                else
                    hashSet.add(board[i][j]);
            }
            hashSet.clear();
            for (int j = 0; j < 9; j++) {
                if (hashSet.contains(board[j][i]) && board[j][i] != '.')
                    return false;
                else
                    hashSet.add(board[j][i]);
            }
            hashSet.clear();
        }

        for (int k = 0; k < 9; k++) {
            int x = (k / 3) * 3;
            int y = (k % 3) * 3;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (hashSet.contains(board[x + i][y + j]) && board[x + i][y + j] != '.')
                        return false;
                    else
                        hashSet.add(board[x + i][y + j]);
                }
            }
            hashSet.clear();
        }

        return true;
    }
}
