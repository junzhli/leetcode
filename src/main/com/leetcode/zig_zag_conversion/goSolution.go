package main

import (
	"fmt"
	"strings"
)

func main() {
	s := "A"
	numRows := 1
	fmt.Println(convert(s, numRows))
}

func convert(s string, numRows int) string {
	if numRows == 0 {
		return ""
	}

	var res strings.Builder
	if numRows < 2 {
		for i := 0; i < numRows; i++ {
			for j := i; j < len(s); j += numRows {
				res.WriteString(string(s[j]))
			}
		}
	} else {
		diff := numRows + numRows - 2
		// first row
		for i := 0; i < len(s); i += diff {
			res.WriteString(string(s[i]))
		}

		// rows exclusive of first and last one
		for i := 1; i < numRows-1; i++ {
			interval := diff - i*2
			for j := i; j < len(s); j = j + diff {
				res.WriteString(string(s[j]))
				if j+interval < len(s) {
					res.WriteString(string(s[j+interval]))
				}
			}
		}

		for i := numRows - 1; i < len(s); i += diff {
			res.WriteString(string(s[i]))
		}
	}

	return res.String()
}
