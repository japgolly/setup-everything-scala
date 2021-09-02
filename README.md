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

    - name: Cache sbt
      uses: coursier/cache-action@v6.3
```

## Inputs

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
