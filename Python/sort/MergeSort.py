# -*- coding: utf-8 -*-
def merge(R, low, mid, high):
    size = high - low + 1
    i = low
    j = mid + 1
    k = 0
    R1 = [ 0 for v in range(size)]
    
    while i <= mid and j <= high:
        if R[i] < R[j]:
            R1[k] = R[i]
            i = i + 1
            k = k + 1
        else:
            R1[k] = R[j]
            j = j + 1
            k = k + 1
    while i <= mid:
        R1[k] = R[i]
        i = i + 1
        k = k + 1
    while j <= high:
        R1[k] = R[j]
        j = j + 1
        k = k + 1
        
    k = 0
    i = low
    while i <= high:
        R[i] = R1[k]
        k = k + 1
        i = i + 1

def mergePass(R, length, n):
    i = 0
    while i + 2 * length - 1 < n:
        merge(R, i, i + length - 1, i + 2 * length - 1)
        i = i + 2 * length
    if i + length - 1 < n:
        merge(R, i, i + length - 1, n - 1)

'''
自底向上
'''
def mergeSort(R, n):
    length = 1
    while length < n:
        mergePass(R, length, n)
        length = 2 * length
        
def mergeSortDC(R, low, high):
    if low < high:
        mid = (low + high) / 2
        mergeSortDC(R, low, mid)
        mergeSortDC(R, mid + 1, high)
        merge(R, low, mid, high)
        
array = [49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12,
        64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51]
print "使用自底向上方法进行二路归并排序："
print "排序前的数组是：", array
mergeSort(array, len(array))
print "排序后的数组是：", array

array = [49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12,
        64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51]
print "使用自顶向下方法进行二路归并排序："
print "排序前的数组是：", array
mergeSortDC(array, 0, len(array) - 1)
print "排序后的数组是：", array
