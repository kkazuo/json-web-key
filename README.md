# json-web-key

A Clojure library designed to decode JSON Web Key.

## Usage

    (require '[json-web-key.core :refer :all])

    (jwk->publickey {"kty" "RSA", "n" "l9Cn....", "e" "AQAB"})

You can get example JWKs from:

    % curl -s https://www.googleapis.com/oauth2/v3/certs

## License

Copyright © 2017 Koga Kazuo

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
