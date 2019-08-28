;; https://www.hackerrank.com/challenges/30-2d-arrays/problem
(ns thirty-days-code.hourglass)

(defn hourglass []
  (let [matrix (to-array-2d
                (vec
                 (repeatedly 6
                             (fn [] (->> (clojure.string/split (read-line) #"\s")
                                         (mapv #(Integer/parseInt %)))))))
        indices [[0 0] [0 1] [0 2] [1 1] [2 0] [2 1] [2 2]]
        rc-sums (for [row (range 4) col (range 4)]
                  (let [rc (map (fn [idx]
                                  (aget matrix (+ row (first idx)) (+ col (last idx)))) indices)]
                    (reduce + rc)))]
    (println (apply max rc-sums))))
