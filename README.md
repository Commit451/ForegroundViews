# ForegroundViews
Views that supports a foreground, like FrameLayout does. Inspired by [Chris Banes' gist]( https://gist.github.com/chrisbanes/9091754) and this [post](https://plus.google.com/+NickButcher/posts/azEU6s4APbu).

![Sample Gif](https://raw.githubusercontent.com/Commit451/ForegroundViews/master/art/image_ripple.gif)

[![Build Status](https://travis-ci.org/Commit451/ForegroundViews.svg?branch=master)](https://travis-ci.org/Commit451/ForegroundViews)

# Gradle Dependency
Easily reference the library in your Android projects using this dependency in your module's `build.gradle` file:

```Gradle
dependencies {
    compile 'com.commit451:foregroundviews:1.0.0'
}
```

# Usage
Usage is very similar for each of the foreground views. Within XML:

```xml
<com.commit451.foregroundimageview.ForegroundLinearLayout
  android:layout_width="match_parent"
  android:layout_height="wrap_content"
  android:clickable="true"
  android:foreground="?attr/selectableItemBackgroundBorderless"
  android:orientation="vertical"
  android:padding="16dp">

  <!-- Other views go here -->

</com.commit451.foregroundimageview.ForegroundLinearLayout>
```
for `ViewGroup`s and:
```xml
<com.commit451.foregroundimageview.ForegroundImageView
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

There may be others that people want, so pull requests are encouraged!

License
--------

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
