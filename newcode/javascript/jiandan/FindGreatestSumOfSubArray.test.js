const findGreatestSumOfSubArray = require("./FindGreatestSumOfSubArray.js");


describe('FindGreatestSumOfSubArray', function() {
    describe('test1', () => {
        it('tets1', () =>{
            let arr = [1,-2,3,10,-4,7,2,-5]
            expect(findGreatestSumOfSubArray.FindGreatestSumOfSubArray(arr)).toBe(18);

        });
    });
});