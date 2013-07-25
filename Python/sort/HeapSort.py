# -*- coding: utf-8 -*-
def sift(array, low, high):
    i = low
    j = 2 * (i + 1) - 1
    tmp = array[i]
    while j <= high:
        if j < high and array[j] < array[j + 1]:
            j = j + 1
        if tmp < array[j]:
            array[i] = array[j]
            i = j
            j = 2 * (i + 1) - 1
        else:
            break
    array[i] = tmp

def heapSort(array):
    i = 0
    tmp = 0
    length = len(array)
    for i in reversed(range((length - 1) / 2 + 1)):
        sift(array, i, length - 1)
    for i in reversed(range(1, length)):
        tmp = array[0]
        array[0] = array[i]
        array[i] = tmp
        sift(array, 0, i - 1)

array = [49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12,
        64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51]

print "排序前的数组是：", array
heapSort(array)
print "排序后的数组是：", array
