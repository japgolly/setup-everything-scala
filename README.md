# 'Setup Scala' GitHub Action

A GitHub Action to prepare the environment for Scala & Scala.JS dev and testing.

Use this:

```yaml
    - name: Setup Scala
      uses: japgolly/setup-scala@latest
```

To replace this:

```yaml
    - name: Setup Java and Scala
      uses: olafurpg/setup-scala@v13

    - name: Setup Node
      uses: actions/setup-node@v2

    - name: Setup Scala.JS
      uses: japgolly/setup-scalajs@v1

    - name: Cache sbt
      uses: coursier/cache-action@v6
```

## Inputs

* `java-version` - The Java version to install. Defaults to `adopt@1.8`
* `node-version` - The Node version to install. Defaults to `16`
* `jsdom-version` - The `jsdom` version to install. Defaults to `latest`
* `source-map-support-version` - The `source-map-support` version to install. Defaults to `latest`
