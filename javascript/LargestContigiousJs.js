function largestContiguousSum(arr) {
    let max = Number.MIN_SAFE_INTEGER;
    let sum = 0;
    for (let i = 0; i < arr.length; i++) {
        sum = sum + arr[i];
        if (sum > max) {
            max = sum;
        }
        if (sum < 0) {
            sum = 0
        }
    }
    // console.log(max);
    return max;

}
const arr = [-1, -2, -3, -4, -5];
const max = largestContiguousSum(arr);
console.log(max);


