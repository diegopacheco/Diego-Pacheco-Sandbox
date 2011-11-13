module Main where

fibs = 1 : 1 : zipWith (+) fibs (tail fibs)

main = print $ take 20 fibs