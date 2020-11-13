# SuperViewpager
[![](https://jitpack.io/v/skhanbeiki/SuperViewpager.svg)](https://jitpack.io/#skhanbeiki/SuperViewpager)
##### SuperViewpager for android

With SuperViewpager you can easily use fragments.

 ![alt text](https://github.com/skhanbeiki/SuperViewpager/blob/master/image/viewpager.gif)
 
You can create multiple fragments.
Set a time to run the fragments.
Repeat the fragments each time.


# Attributes
+ Custom
+ Easy
+ Viewpager
+ Android X

# Can be used in 
```
minSdkVersion 14
```

# Download
You can download a jar from GitHub's [releases page.](https://github.com/skhanbeiki/SuperViewpager/releases)


Or use Gradle:

```java
repositories {
   maven { url 'https://jitpack.io' }
}

dependencies {
   implementation 'com.github.skhanbeiki:SuperViewpager:1.2'
}
```
Or Maven:
```java
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
 
 	<dependency>
	    <groupId>com.github.skhanbeiki</groupId>
	    <artifactId>SuperViewpager</artifactId>
	    <version>Tag</version>
	</dependency>
```

# How to use

```java
        ViewPager viewPager = findViewById(R.id.viewPager);
        
        SuperAdapter adapter = new SuperAdapter(getSupportFragmentManager(), 0);
        adapter.addFragment(0, true, new FrgFirst(), "title");
        adapter.addFragment(1, false, new FrgSecond(), "title");
        adapter.addFragment(2, 1, new FrgThird(), "title");
        adapter.addFragment(3, 5, new FrgFourth(), "title");
        
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(4);
        viewPager.setCurrentItem(0);
```
# Description
```
adapter.addFragment(int id , boolean isDisposable , Fragment fragment , String title);
adapter.addFragment(int id , long minutes , Fragment fragment , String title);
```
The "onFragmentAlwaysDo" method is always executed.

id = The ID must be unique to be stored in the time database.
isDisposable if true = The "onFragmentCommandDo" method is executed only once.
isDisposable if false = The "onFragmentCommandDo" method is always executed.
minutes >= 1 After the desired number (minutes), the "onFragmentCommandDo" method is executed.
# Author

[Moslem Khanbeiki](http://khanbeiki.ir/)

# Thanks

[PagerBottomTabStrip](https://github.com/tyzlmjj/PagerBottomTabStrip)

# Disclaimer

This is not an official Google product.
