# dubbo concepts
## What is @Adaptive annotation and it's purpose?
### concepts:
> this annotation Provide helpful information for {@link ExtensionLoader} to inject dependency extension instance.
#### purpose
>It's can help interface inject adapt implement
#### keyCode
```
class : org.apache.dubbo.common.extension.ExtensionLoader

public T getAdaptiveExtension() {
    Object instance = cachedAdaptiveInstance.get();
    if (instance == null) {
        if (createAdaptiveInstanceError != null) {
            throw new IllegalStateException("Failed to create adaptive instance: " +
                    createAdaptiveInstanceError.toString(),
                    createAdaptiveInstanceError);
        }

        synchronized (cachedAdaptiveInstance) {
            instance = cachedAdaptiveInstance.get();
            if (instance == null) {
                try {
                    instance = createAdaptiveExtension();
                    cachedAdaptiveInstance.set(instance);
                } catch (Throwable t) {
                    createAdaptiveInstanceError = t;
                    throw new IllegalStateException("Failed to create adaptive instance: " + t.toString(), t);
                }
            }
        }
    }
    return (T) instance;
}

```
#### example in dubbo 
```
(1)
in class ReferenceConfig<T>
private static final Protocol REF_PROTOCOL = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();

(2)
in interface Protocol 

@Adaptive
<T> Exporter<T> export(Invoker<T> invoker) throws RpcException;
```

### RegistryDirectory.refreshInvoker


