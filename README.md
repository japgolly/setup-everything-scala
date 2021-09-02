# 'Setup Scala' GitHub Action

A GitHub Action to prepare the environment for Scala & Scala.JS dev and testing.

Use this:

```yaml
    - name: Setup Scala
      uses: japgolly/setup-everything-scala@v1.0
```

To replace (a subset of) this:

```yaml
    - name: Setup Java and Scala
      uses: olafurpg/setup-scala@v13

    - name: Setup Node
      uses: actions/setup-node@v2

    - name: Setup Scala.JS
      uses: japgolly/setup-scalajs@v1

    - name: Setup Scala Utils
      uses: japgolly/setup-scala-util@v1.1

    - name: Cache sbt
      uses: coursier/cache-action@v6.3
```

# Dynamic Scala Versions

If you have your Scala versions stored as `val`s or `def`s in your sbt field, then you can use `sbt++field` to set
the Scala version dynamically. Example:

`build.sbt`:
```scala
  val scala211 = "2.11.10"
  val scala212 = "2.12.8"
  val scala213 = "2.13.6"
  val scala3   = "3.0.2"
```

`.github/workflows/ci.yaml`:
```yml
name: CI
on:
  pull_request:
  push:
jobs:
  ci:
    runs-on: ubuntu-latest
    strategy:
      matrix:
        include:
          - scala: scala211
          - scala: scala212
          - scala: scala213
          - scala: scala3

    steps:
      - name: Git checkout
        uses: actions/checkout@v2

      - name: Setup Scala
        uses: japgolly/setup-everything-scala@v1.1

      - name: Build and test
        shell: bash
        run: sbt++field ${{ matrix.scala }} test
```

# Inputs

All inputs are optional.
See [`actions.yml`](https://github.com/japgolly/setup-everything-scala/blob/master/action.yml) for descriptions and defaults.

* `coursier-cache-ammoniteScripts`
* `coursier-cache-extraAmmoniteHashedContent`
* `coursier-cache-extraAmmoniteKey`
* `coursier-cache-extraFiles`
* `coursier-cache-extraHashedContent`
* `coursier-cache-extraKey`
* `coursier-cache-extraMillFiles`
* `coursier-cache-extraMillHashedContent`
* `coursier-cache-extraMillKey`
* `coursier-cache-extraSbtFiles`
* `coursier-cache-extraSbtHashedContent`
* `coursier-cache-extraSbtKey`
* `coursier-cache-job`
* `coursier-cache-matrix`
* `coursier-cache-path`
* `coursier-cache-root`
* `jabba-version`
* `java-version`
* `jsdom-version`
* `node-always-auth`
* `node-architecture`
* `node-cache-dependency-path`
* `node-cache`
* `node-check-latest`
* `node-registry-url`
* `node-scope`
* `node-token`
* `node-version`
* `source-map-support-version`
