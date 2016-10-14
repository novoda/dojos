module Main
where

import System.Environment
import qualified Data.Text as T
import Data.List
import Tic

main :: IO()
main = do
    args <- getArgs
    let player = readPlayer $ args!!1
    let board = readBoard $ args!!0
    print . fst . nextMove player $ board

printBoard :: Board -> IO [()]
printBoard = mapM (do print) . map showRow

showRow :: Row -> String
showRow = concat . intersperse "|" . map showCell

showCell :: Cell -> String
showCell (Just X) = "X"
showCell (Just O) = "0"
showCell Nothing = "_"

readPlayer :: String -> Player
readPlayer "x" = X
readPlayer "X" = X
readPlayer "o" = O
readPlayer "O" = O
readPlayer "0" = O

readBoard xs = first:second:third:[]
    where 
        first = take 3 xs
        second = take 3 . drop 3 $ xs
        third = take 3 . drop 6 $ xs

readCells = map (asCell . T.unpack) . T.split (==',') . T.pack

asCell :: String -> Cell
asCell "x" = Just X
asCell "X" = Just X
asCell "o" = Just O
asCell "O" = Just O
asCell "0" = Just O
asCell _ = Nothing
