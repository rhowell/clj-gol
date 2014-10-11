(ns clj-gol.board-generator
  (:require [clojure.set]))

; Offsets to calculate neighbours of a given cell
(def offsets [[-1,-1], [ 0,-1], [1,-1],
              [-1, 0],        , [1, 0],
              [-1, 1], [ 0, 1], [1, 1]])

; Calculate imediate neighbours of this node, alive or dead
(defn my-neighbours [node]
  (map #(vector (+ (first node) (first %)) 
                (+ (second node) (second %))) 
       offsets)) 

; Counts the number neighbours for this node
(defn neighbour-count [node state]
  (let [neighbours (my-neighbours node)]
    (count (clojure.set/intersection (set neighbours) (set state)))))

; Find all the neighbours and then remove anything in common with state
(defn calculate-candidates [state]
  (remove #(some #{%} state)
          (distinct (mapcat #(my-neighbours %) state))))

; Calculates living cells that will survive to the next round
(defn calculate-remainders [state]
  (filter #(or (= (neighbour-count % state) 2) 
               (= (neighbour-count % state) 3)) state))
  
; Calculate dead cells that will be reborn
(defn calculate-genesis [state]
  (let [candidates (calculate-candidates state)]
    (filter #(= (neighbour-count % state) 3) candidates)))

; Generates the next state given a current state
(defn generate-state [state]
  (into (calculate-genesis state)
        (calculate-remainders state)))

        
