一、判断一个数A做了一个运算后是否溢出思路
1、使用更大的范围数值类型存放，如A为int类型，使用long存储运算后的值，判断long>Integer.MAX_VALUE是否为true
2、对Integer.MAX_VALUE 做反操作得出B，对Integer.MIN_VALUE 做反操作得出C，，判断A是否大于B 或 小于C