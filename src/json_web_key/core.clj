(ns json-web-key.core
  (:require [jerks-whistling-tunes.utils :as utils])
  (:import java.math.BigInteger
           java.security.KeyFactory
           java.security.PublicKey
           java.security.spec.RSAPublicKeySpec))

;; You can get JWKs from:
;; % curl -s https://www.googleapis.com/oauth2/v3/certs | jq

(defn jwk->publickey
  "Decode JWK to PublicKey object.

  jwk should be a map that has n, e and kty keys.

  You can change map key with :key-fn (default key is string)"
  [jwk &{:keys [key-fn] :or {key-fn identity}}]
  (let [kty (get jwk (key-fn "kty"))
        n   (some-> (get jwk (key-fn "n"))
                    ^bytes (utils/decode-base-64)
                    (BigInteger.))
        e   (some-> (get jwk (key-fn "e"))
                    ^bytes (utils/decode-base-64)
                    (BigInteger.))]
    (and kty n e
         (->> (RSAPublicKeySpec. n e)
              (.generatePublic (KeyFactory/getInstance kty))))))
