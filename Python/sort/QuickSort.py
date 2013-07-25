# -*- coding: utf-8 -*-
def quickSort(array, low , high):
    i = low
    j = high
    tmp = 0
    if low < high:
        tmp = array[low]
        while i != j:
            while j > i and array[j] > tmp:
                j = j - 1
            array[i] = array[j]
            while i < j and array[i] <= tmp:
                i = i + 1
            array[j] = array[i]
        array[j] = tmp
        quickSort(array, low, j - 1)
        quickSort(array, j + 1, high)
        
        
array = [49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12,
        64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51]

print "排序前的数组是：",array
quickSort(array,0,len(array)-1)
print "排序后的数组是：",array
