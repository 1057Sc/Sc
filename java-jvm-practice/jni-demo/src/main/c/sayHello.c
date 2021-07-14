#include "stdio.h"
#include "org_sc_DemoJni.h"

JNIEXPORT jstring JNICALL Java_org_sc_DemoJni_sayHello
  (JNIEnv *env, jclass jc, jstring name)
{
	return name;
}



