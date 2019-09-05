(ns thirty-days-code.prime-number)

(defn sieve [m]
  (let [primes []]
    (if (<= m 1)
      primes
      (loop [i 2
             memo (into [] (boolean-array (inc m) true))
             primes primes]
        (if (= i (inc m))
          primes
          (if (get memo i)
            (recur (inc i)
                   (reduce (fn [acc idx] (assoc acc idx false)) memo (range (* i 2) (inc m) i))
                   (conj primes i))
            (recur (inc i)
                   memo
                   primes)))))))

(defn prime? [n primes]
  (let [search (fn [n p i]
                 (cond
                   (= i (count p)) true
                   (zero? (mod n (get p i))) false
                   :else (recur n p (inc i))))]
    (if (zero? (count primes))
      true
      (search n primes 0))))

(defn prime-number [n]
  (if (<= n 1) "Not prime"
      (let [m (int (Math/sqrt n))
            primes (sieve m)]
        (case (prime? n primes)
          true "Prime"
          false "Not prime")))
  )

