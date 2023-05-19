
# Custom Progress





- Custom step progress view with three color (Progress color, current selected progress color, Unselected color)
- You can set custom height
- You can set space between the progress
- Set progress complete if you want fill all progress.


## Screenshots

![App Screenshot](https://i.ibb.co/10NMxsW/Screenshot-5.png)


## Installation

### Install Custom Progress for **gradle**
- Add it in your root build.gradle at the end of repositories:

```bash
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

- Add the dependency
``` bash
dependencies {
	        implementation 'com.github.Kets1390:CustomeProgress:Latest_Version'
	}

```
### Install Custom Progress for **maven**

```bash
    <repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```
- Add the dependency
``` bash
    <dependency>
	    <groupId>com.github.Kets1390</groupId>
	    <artifactId>CustomeProgress</artifactId>
	    <version>1.1</version>
	</dependency>
```
## XML
``` bash
  <com.custom_progress.CustomProgressView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
    	app:progress_color="#4d304e"
        app:current_progress="5"
        app:normal_color="#D6D9E1"
        app:total_progress="7"
        app:selected_color="#1eadc0"
        android:id="@+id/ThirdView"
        app:space="0dp"
        />
```
## Attributes



| Parameter | Type      | Default | Description |
| :-------- | :-------  | :-----------| :------ |
| `total_progress`      | `integer`   | **5** | Total Progress count  |
| `current_progress`      | `integer`   | **0** | Current Progress count  |
| `space`      | `dimension`   | **2dp** | Space between progress and set 0 for no need space  |
| `height`      | `dimension`   | **15dp** | ProgressView height  |
| `progress_color`      | `color`   | **Color.BLUE** | Completed progress color  |
| `selected_color`      | `color`   | **Color.GREEN** | Selected/Current Progress color  |
| `normal_color`      | `color`   | **Color.GRAY** | Unselected Progress color  |
| `progress_complete`      | `boolean`   | **false** | **true** : All progress completed, **false**: All progress not completed    |





## Set programmatically
### Methods

| Name | Parameters       | Description |
| :-------- | :--------  | :---------- |
| setTotal_progress | **Context** context, **int** total_progress,**int** current_progress |  Set total progress and current progress using this method.|
|setCurrent_progress | **Context** context, **int** current_progress | Set current progress ussing this method. |
| isProgressCompleted | **Context** context, **boolean** isComplete | Set all progress complete using this methos. |




## Support

For support, email kets1390ketu@gmail.com

