package _go

import "testing"

func TestFindGreatestSumOfSubArray(t *testing.T) {
	type args struct {
		array []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := FindGreatestSumOfSubArray(tt.args.array); got != tt.want {
				t.Errorf("FindGreatestSumOfSubArray() = %v, want %v", got, tt.want)
			}
		})
	}
}