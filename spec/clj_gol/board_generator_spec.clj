(ns clj-gol.board-test-spec
  (:require [speclj.core             :refer :all]
            [clj-gol.board-generator :refer :all]))

(describe "Generating a board state"
          (it "will die with 0 neighbours"
              (let [state [[1,1]]]
                (should (= (generate-state state)
                           []))))
          (it "death with a single neighbour"
              (let [state [[1,1], [1,2]]]
                (should (= (generate-state state)
                           []))))
          (it "Life with 2 neighbours"
              (let [state [[1,0], [1,1], [1,2]]]
                (should (= (generate-state state)
                           [[1,1]]))))
          (it "Life with 3 neighbours"
              (let [state [[0,0], [0,1], [1,0], [1,1]]]
                (should (= (generate-state state) 
                           state))))
          (it "Death with 4 neighbours"
              (let [state [[2,2], [0,0], [0,1], [1,0], [1,1]]]
                (should (= (generate-state state) 
                           [[0,0], [0,1], [1,1]]))))
          (it "Death with 5 neighbours"
              (let [state [[2,2], [1,2], [0,0], [0,1], [1,0], [1,1]]]
                (should (= (generate-state state) 
                           [[0,0], [0,1], [1,2], [2,2]]))))
          (it "rebirth with 3 neighbours"
              (let [state [[0,1], [1,0], [2,1]]]
                (should (= (generate-state state)
                           [[1,1]])))))

(run-specs)
