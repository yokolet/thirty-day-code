;; https://www.hackerrank.com/challenges/30-sorting/problem
(ns thirty-days-code.bubble-sort)

(defn bubble-sort []
  (let [n (Integer/parseInt (clojure.string/trim (read-line)))
        v (->> (clojure.string/split (read-line) #"\s")
               (mapv #(Integer/parseInt %)))
        swap (fn [v idx1 idx2] (assoc v idx2 (v idx1) idx1 (v idx2)))
        swap-and-count (fn [c v idx]
                        (if (> (get v idx) (get v (inc idx)))
                          [(inc c) (swap v idx (inc idx))]
                          [c v]))
        inner (fn [v] (loop [c 0 v v j 0]
                        (if (= j (dec n))
                          [c v]
                          (let [[c v] (swap-and-count c v j)]
                            (recur c v (inc j))))))]
    (loop [cnt 0 v v i 0]
      (let [[sub v] (inner v)]
        (if (or (= 0 sub) (= i (dec n)))
          (do
            (println (str "Array is sorted in " cnt " swaps."))
            (println (str "First Element: " (first v)))
            (println (str "Last Element: " (last v))))
          (recur (+ cnt sub) v (inc i))))))
  )

