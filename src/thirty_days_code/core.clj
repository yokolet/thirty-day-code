(ns thirty-days-code.core)

;; https://www.hackerrank.com/challenges/30-hello-world/problem
(defn hello-world []
  (println "Hello, World.")
  (println (read-line)))

;; https://www.hackerrank.com/challenges/30-operators/problem
(defn solve [meal_cost tip_percent tax_percent]
    (println (Math/round (* meal_cost (+ 1 (/ (+ tip_percent tax_percent) 100))))))

;; https://www.hackerrank.com/challenges/30-loops/problem
(defn mut-print []
  (let [x (Integer/parseInt (clojure.string/trim (read-line)))]
    (doseq [y (take 10 (range 1 11))]
      (prn x 'x y '= (* x y)))))

;; https://www.hackerrank.com/challenges/30-recursion/problem
(defn factorial [n]
  (reduce * 1 (range n 0 -1)))

