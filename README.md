# clojure-bitvavo-api

This is a library to make it easier for Clojure users to access the Bitvavo API.

At this stage I have not yet reproduced much of the functionality in idiomatic Clojure 
(i.e. functional programming), instead you will have to resort to using the 'dot-notation'/interop syntax.

Take a look at src/clj/clojure_bitvavo_api/examples.clj to see how to use Bitvavo Java classes in this way.

For more information on how to use Java interop:
https://clojure-doc.org/articles/language/interop/
https://www.braveclojure.com/java/

To see the functionality built into the origional Java code:
https://github.com/bitvavo/java-bitvavo-api/tree/471b5aedd15e3330edc4dd886e19ce77a50a24b9
(this is the last commit since I forked the Java code, so subsiquent updates/functionality may be slow to be incorperated into this codebase).

You can also checkout the docs from Bitvavo:
https://docs.bitvavo.com/
however these do not refer the *this* clojure codebase. You should look at the Java code examples and work from there.

I plan to wrap up all those Classes and objects inside functions, in future.

This is a personal project created to make my life (i.e. my personal projects) easier, if it makes your life easier, feel free to use it.

Updates and improvements may be slow.


## Installation

At the moment this project does not have a clojar. To make use of this library in my own work I use another library to help fetch this library from github.

You will need to add something like the following to the your project.clj file.

====
:dev-dependencies [[lein-git-deps "0.0.1-SNAPSHOT"]] ;; for clojure-bitvavo-api
:git-dependencies [["https://github.com/Amsteldammer/clojure-bitvavo-api"]] ;; for clojure-bitvavo-api
:extra-classpath-dirs [".lein-git-deps/monger/src/"] ;; for clojure-bitvavo-api
====

## Usage

To use in your own code:

(ns my-namespace.core
  (:require [clojure-bitvavo-api :as clj-btvo])
  (:gen-class))

See code examples in: src/clj/clojure_bitvavo_api/examples

## Examples

TODO: show some code examples.

### Bugs
TODO: find bugs.



## License

Copyright © 2022 Robert Tann (Github: Amsteldammer), for Clojure parts.
Copyright © 2018 Bitvavo, for Java parts.

ISC License

Permission to use, copy, modify, and/or distribute this software for any
purpose with or without fee is hereby granted, provided that the above
copyright notice and this permission notice appear in all copies.

THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.

