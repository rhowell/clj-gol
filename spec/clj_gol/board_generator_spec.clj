(ns clj-gol.board-generator-spec
  (:require [speclj.core             :refer :all]
            [speclj.run.standard]
            [clj-gol.board-generator :refer :all]))

(describe "Given a living cell"
          (it "will calculate all of its neighbours"
              (let [node [0,0]]
                (map #(should-contain offsets %)
                     (calculate-neighbours node)))))

; Must create a should matcher that checks arrays out of order 
(describe "Generating a board state"
          (it "will die with 0 neighbours"
              (let [state [[1,1]]]
                (should= [] (generate-state state))))
          (it "death with a single neighbour"
              (let [state [[1,1], [1,2]]]
                (should= [] (generate-state state))))
          (it "Life with 2 neighbours"
              (let [state [[1,0], [1,1], [1,2]]]
                (should= [[1,1], [0,1], [2,1]] (generate-state state))))
          (it "Life with 3 neighbours"
              (let [state [[0,0], [0,1], [1,0], [1,1]]]
                (should= (reverse state) (generate-state state) )))
          (it "Death with 4 neighbours"
              (let [state [[2,2], [0,0], [0,1], [1,0], [1,1]]]
                (should= [[1 0] [0 1] [0 0] [2 1] [1 2]] (generate-state state))))
          (it "Death with 5 neighbours"
              (let [state [[2,2], [1,2], [0,0], [0,1], [1,0], [1,1]]]
                (should= [[1 0] [0 0] [1 2] [2 2] [0 2]] (generate-state state))))
          (it "rebirth with 3 neighbours"
              (let [state [[0,1], [1,0], [2,1]]]
                (should= [[1,0],[1,1]] (generate-state state)))))

(run-specs)
