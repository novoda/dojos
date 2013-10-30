module BowlingSpec where

import Test.Hspec
import Bowling

main :: IO()
main = hspec spec

spec :: Spec
spec = do
    describe "score" $ do
        it "is 0 for all gutters" $ do
            (score $ replicate 20 0) `shouldBe` 0
