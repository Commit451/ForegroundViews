# ForegroundViews
Views that support a foreground. Inspired by [Chris Banes' gist]( https://gist.github.com/chrisbanes/9091754) and this [post](https://plus.google.com/+NickButcher/posts/azEU6s4APbu) as well as [this](https://github.com/NightlyNexus/cardslib/blob/master/library-core/src/main/java/it/gmariotti/cardslib/library/view/ForegroundLinearLayout.java).

![Sample Gif](https://raw.githubusercontent.com/Commit451/ForegroundViews/master/art/image_ripple.gif)

[![Build Status](https://travis-ci.org/Commit451/ForegroundViews.svg?branch=master)](https://travis-ci.org/Commit451/ForegroundViews) [![](https://jitpack.io/v/Commit451/ForegroundViews.svg)](https://jitpack.io/#Commit451/ForegroundViews)

# Gradle Dependency

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

Then, add the library to your project `build.gradle`
```gradle
dependencies {
    compile 'com.github.Commit451:ForegroundViews:latest.version.here'
}
```

# Usage
Usage is very similar for each of the foreground views. Within XML:

```xml
<com.commit451.foregroundviews.ForegroundLinearLayout
  android:layout_width="match_parent"
  android:layout_height="wrap_content"
  android:clickable="true"
  android:foreground="?attr/selectableItemBackgroundBorderless"
  android:orientation="vertical"
  android:padding="16dp">

  <!-- Other views go here -->

</com.commit451.foregroundviews.ForegroundLinearLayout>
```
for `ViewGroup`s and:
```xml
<com.commit451.foregroundviews.ForegroundImageView
  android:layout_width="match_parent"
  android:layout_height="wrap_content"
  android:background="@color/colorPrimary"
  android:clickable="true"
  android:foreground="?attr/selectableItemBackgroundBorderless"
  android:src="@drawable/header_image_1"
  android:tint="@color/colorAccent" />
```
for an `ImageView`.
The key is the `foreground` XML attribute, which can also be set in code:
```java
Drawable drawable = ContextCompat.getDrawable(this, R.drawable.foreground);
ForegroundImageView foregroundImageView = (ForegroundImageView) findViewById(R.id.image);
foregroundImageView.setForeground(drawable);
```

# Supported Views
- ForegroundImageView
- ForegroundLinearLayout
- ForegroundRelativeLayout
- ForegroundButton
- ForegroundTextView

There may be others that people want, so pull requests are encouraged! Please note that `FrameLayout` and `CardView` already support a foreground for all API levels.

# Create Your Own Views
If you take a look at the source, you will see that the supported views all are very similar in construction. Operations are overridden in the views and then passed along to the `ForegroundDelegate` so that the foreground logic is easily shared and reusable on new views. Most of the time, copying the source of `ForegroundLinearLayout` and then modifying the name and the extended view is all you need to do.

# Note
Foregrounds were added to `View` as of Android 6.0 (API 23). This library calls through to the 6.0+ methods whenever it is possible. If you have the ability to target 6.0+ (lol yeah right) then you have no need for a library like this. We look forward to the day when targeting 6.0+ is the standard and this library can be deprecated.

License
--------

    Copyright 2016 Gabriele Mariotti
    Copyright 2016 Eric Cochran
    Copyright 2016 Chris Banes
    Copyright 2016 Commit 451

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
