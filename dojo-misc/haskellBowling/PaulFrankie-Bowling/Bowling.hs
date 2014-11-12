module Bowling (score)
where

score :: [Int] -> Int
score game = sum game + calc_bonus game

calc_bonus :: [Int] -> Int
calc_bonus [] = 0
calc_bonus (last:[]) = 0
calc_bonus (last1:last2:[]) = 0
calc_bonus (last1:last2:last3:[]) = 0
calc_bonus (first:second:third:rest)
	| first == 10 = second + third + calc_bonus(second:third:rest)
	| first + second == 10 = third + calc_bonus (third:rest)
        | otherwise = calc_bonus (third:rest)
