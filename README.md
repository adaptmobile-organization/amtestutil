# amutestutil
Adaptmobile util for testing (see Aeldresagen for example of usage)

## Installation

#### Add jitpack repository to top (project) build.gradle file:

    maven { url 'https://jitpack.io' }

    Example:
    allprojects {
        repositories {
            jcenter()
            maven { url 'https://jitpack.io' }
        }
    }

#### Add dependency to app (module) build.gradle file:

    compile 'com.github.adaptmobile-organization:amtestutil:version'

  Example:
    
    dependencies {
        compile 'com.github.adaptmobile-organization:amtestutil:1.0.3'
    }
    
#### Add test libraries dependencies

    testCompile 'junit:junit:4.12'
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    androidTestCompile ('com.android.support.test.espresso:espresso-contrib:2.2.2'){
        exclude group: 'com.android.support', module: 'appcompat-v7'
        exclude group: 'com.android.support', module: 'support-v4'
        exclude group: 'com.android.support', module: 'design'
        exclude module: 'recyclerview-v7'
    }
    androidTestCompile ('com.android.support.test.espresso:espresso-web:2.2.2') {
        exclude group: 'com.android.support', module: 'support-annotations'
    }
    androidTestCompile "com.android.support:support-annotations:${supportLibVersion}"
    androidTestCompile 'com.android.support.test:runner:0.5'
    androidTestCompile 'com.android.support.test:rules:0.4'

    androidTestCompile 'com.android.support.test.uiautomator:uiautomator-v18:2.1.1'

Notice that the support-annotations need to match the projects supportlib version

#### Add testInstrumentationRunner to defaultConfig
    testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"

#### Add debug manifest (allows enabling and disabling of animations on your test device)


## Usage
UI tests are instrumentation tests and needs to be in the directory:
{projectname}/app/src/androidTest/java

Create a testClass and make it extend AMBaseUITest:
    public class MainActivityTest extends AMBaseUITest
This class makes sure to enable and disable animations in @BeforeClass and @AfterClass, if your project is set up correctly.
Be sure to call these methods (setupClass/tearDownClass) if you use your own/override @BeforeClass/@AfterClass. If not done, your test will most likely fail if animations are enabled on your test device.

Add ActivityTestRule:

      @Rule
      public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
This rule sets up/starts every test from the defined activity.

Create test methods:

      @Test
      public void memberCardTest() {
          clickView(R.id.topBarMemberCardIcon);

          viewIsDisplayed(R.id.memberCardContainer);
          viewIsDisplayed(R.id.closeButton);

          clickView(R.id.closeButton);
          clickView(R.id.topBarMemberCardIcon);

          //exits application, do this as the last item
          clickView(R.id.memberCardContact);
      }
See Aldresagen MainActivityTest for more advanced examples, but the methods in the amtestutil are pretty self explanatory.
If you find/need methods that are useful, please add them to this repository.

## Development

  Push a new/the next tag for a new version of amutil on jitpack

## Jitpack

  https://jitpack.io/#adaptmobile-organization/amutestutil
