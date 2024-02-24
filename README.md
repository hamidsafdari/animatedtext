# Morphing Number

![Morphing Counter Preview GIF](/assets/morph.gif)

An Android library for animating texts.

## Usage

1. Add the dependency to your project
    ```kotlin
    // add this in your root build.gradle file at the end of repositories
    dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url("https://jitpack.io") }
		}
	}

   dependencies {
      implementation("com.github.hamidsafdari:animatedtext:0.1")
   }
    ```
2. Use it in any composable
    ```kotlin
    var count by remember { mutableLongStateOf(1000) }

    Surface(
        modifier = Modifier
            .width(300.dp)
            .height(110.dp),
        onClick = { count += 1 }
    ) {
        MorphingNumber(number = count)
    }
    ```

## Contributing

Send in a Pull Request!

## License

Morphing Counter is licensed under the GPLv3, see the [LICENSE](LICENSE) file for details.