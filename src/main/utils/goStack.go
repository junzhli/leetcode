package utils

import "sync"

type Stack struct {
	array []interface{}
	sync.RWMutex
}

func (s *Stack) Pop() interface{} {
	s.Lock()
	defer s.Unlock()

	res := s.array[len(s.array)-1]
	s.array[len(s.array)-1] = nil
	s.array = s.array[:len(s.array)-1]
	return res
}

func (s *Stack) Push(value interface{}) {
	s.Lock()
	defer s.Unlock()
	s.array = append(s.array, value)
}

func (s *Stack) Reset() {
	s.Lock()
	defer s.Unlock()
	s.array = nil
}

func (s *Stack) Peak() interface{} {
	s.RLock()
	defer s.RUnlock()
	return s.array[len(s.array)-1]
}
