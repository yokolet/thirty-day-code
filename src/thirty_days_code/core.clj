(ns thirty-days-code.core)

(defn weird?
  "prints 'weird' if a condition meets"
  [x]
  (let [f1 (fn [x] (<= 2 x 5))
        f2 (fn [x] (< 20 x))]
    (if (and (even? x) (or (f1 x) (f2 x)))
      "Not Weird"
      "Weird")))

(defn odd-or-even
  "returns odd and even indices str"
  [s]
  (let [ss (seq s)]
    (loop [ss ss
           key :even
           result {:even "" :odd ""}]
      (if (empty? ss)
        result
        (recur (rest ss)
               (if (= key :even) :odd :even)
               (update-in result [key] str (first ss)))))))

(defn odd-or-even2
  [s]
  (let [ss (seq s)
        keys [:even :odd]
        f (fn [acc v]
            (-> acc (update-in [(nth keys (:idx acc))] str v)
                (update-in [:idx] bit-xor 1)))]
    (reduce f {:idx 0 :even "" :odd ""} ss)))

(comment
  ;; the first line is the number of test cases from stdin
  ;; after the second line, input strings come from stdin
  (def N (Integer/parseInt (clojure.string/trim (read-line))))
  (doseq [s (line-seq (java.io.BufferedReader. *in*))]
    (let [result (odd-or-even s)]
      (println (:even result) (:odd result))))

  )

(defn reverse-print [a]
  (clojure.string/join " " (reverse a)))

(comment
  ;; the first line containes an integer n ( the size of input array)
  ;; the second line contains n space-separated integers
  (def n (Integer/parseInt (clojure.string/trim (read-line))))

  (def arr (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

  (println (clojure.string/join " " (reverse arr)))

  )

(defn phone-number []
  )
