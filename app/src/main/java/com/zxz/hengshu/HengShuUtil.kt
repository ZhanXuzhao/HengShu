package com.zxz.hengshu

import java.lang.StringBuilder

/**
 * @author : Zhan Xuzhao
 * e-mail : 649912323@qq.com
 * time   : 2019-09-08 09:30
 * desc   :
 * version: 1.0
 */

fun heng2shu(input: String, space: String = "    ", columnSpace: String = ""): String {
    val inputSplit = input.split("\n")
    val row = inputSplit.size
    var col = 0
    for (s in inputSplit) {
        if (s.length > col) {
            col = s.length
        }
    }
    val resultList = mutableListOf<String>()
    for (c in 0 until col) {
        resultList.add("")
    }
    for (c in 0 until col) {
        for (r in 0 until row) {
            if (inputSplit[r].length > c) {
                resultList[c] = resultList[c] + inputSplit[r][c]
                if (r < row - 1) {
                    resultList[c] = resultList[c] + columnSpace
                }
            } else {
                resultList[c] = resultList[c] + space
            }
        }
    }
    val resultString = StringBuilder()
    for (i in 0 until resultList.size) {
        resultString.append(resultList[i])
        if (i < resultList.size - 1) {
            resultString.append("\n")
        }
    }
    return resultString.toString()
}