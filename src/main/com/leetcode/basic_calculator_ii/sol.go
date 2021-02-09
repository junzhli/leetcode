package main

import (
	"fmt"
	"unicode"
)

func main() {
	c := '0'
	fmt.Printf("%c %d %T\n", c, c, c)
	fmt.Printf("%v\n", c == 48)
	fmt.Printf("%v\n", c == '0')

	for _, _c := range "01234" {
		fmt.Printf("%c %d %T\n", _c, _c, _c)
		fmt.Printf("%v\n", _c == 48)
		fmt.Printf("%v\n", _c == '0')
		fmt.Printf("%v\n", isNumeric(_c))
		fmt.Printf("%v\n", unicode.IsDigit(_c))
	}
}

func isNumeric(c int32) bool {
	return c >= '0' && c <= '9'
}
