
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
	it "is 20 for all ones" $ do
	    (score $ replicate 20 1) `shouldBe` 20
        it "is 29 for spare in first frame" $ do
            (score $ 6:4:replicate 18 1) `shouldBe` 29
        it "is 31 for spare in second frame" $ do
	    (score $ 1:1:6:4:2:replicate 15 1) `shouldBe` 31
	it "is 30 for strike in first frame" $ do
	    (score $ 10:replicate 18 1) `shouldBe` 30	
	it "is 300 for perfect game" $ do
            (score $ replicate 12 10) `shouldBe` 300
    describe "bens" $ do
        it "is 0 for all gutters" $ do
            (score $ replicate 20 0) `shouldBe` 0
        it "is summing score of every ball played" $ do
            (score $ replicate 20 1) `shouldBe` 20
            (score $ replicate 20 3) `shouldBe` 60
        it "is adding next ball bonus if frame is spare" $ do
            (score $ 5:5:3: (replicate 16 0)) `shouldBe` 16
            (score $ 5:5: (replicate 18 1)) `shouldBe` 29
        it "is adding next two balls bonus if frame is strike" $ do
            (score $ 10:3:4: (replicate 16 0)) `shouldBe` 24
            (score $ 10: replicate 18 1) `shouldBe` 30
        it "is 300 for perfect game" $ do
            (score $ replicate 12 10) `shouldBe` 300
        it "is 150 for all spares" $ do
            (score $ replicate 21 5) `shouldBe` 150
        it "is working for strike followed by spare" $ do
            (score $ 10:5:5: (replicate 17 1)) `shouldBe` 48
        it "is working for spare followed by strike" $ do
            (score $ 10:5:5: (replicate 17 1)) `shouldBe` 48
