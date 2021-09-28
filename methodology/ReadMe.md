# The Three Phases of The Lifecycle

1. Initialization
2. Use
3. Destruction

## 1.Initialization

### 1.1 Bean Factory Initialization

#### 1.1.1 Init: Bean definitions loaded

- Java Configuration
- XML Configuration
- Component scanning and auto configuration

##### 1.1.1.1 Priming the factory

- The bean definitions are loaded into the BeanFactory from all sources
- Id is used to create index for Factory [just the thing that defining by id is this, after that everything is type or reference]
- BeanFactory only contains references at this point. (With metadata to configure it) [Not initiated]

##### 1.1.1.2 Phase Completed

- All beans have been loaded into the BeanFactory
- Beans are just references and metadata at this point
- No object instantiation of your code has occured

#### 1.1.2 Init: PostProcess Bean Definitions

- Perform work on the entire BeanFactory

- Can modify or transform any bean in the factory prior to instantiation

  (Buna örnek ${} gösterilebilir)

##### 1.1.2.1 BeanFactory Processor Interface

- First extension point in the lifecycle

- Allows you to write custom components to impact the BeanFactory

  - [If you want to impact every bean or some sub bean use this]

  - Genelde yeni oluşturulmaz var olan(RegisteringScope, Properties) kullanılır.

##### 1.1.2.2 BeanFactoryPostProcessors(BFPP) and Java Configuration

- Bean definitions must be static
- Removes risk of side effects of dynamic instances

##### 1.1.2.3 Phase Completed

- BeanFactory is loaded with references
- BeanFactory and all beans in it are configured
- All system-level work is completed in Spring at this point

### 1.2 Init: Instantiation Phase

#### 1.2.1.1 Construction

- Beans are instantiated in the factory using the constructors
- Done in the correct order to ensure dependencies are create first
- Handle to class instance remains in the bean factory for the lifecycle of the application for singletons. [ Applying singleton ]

#### Eager vs Lazy

- By default, all beans are instantiated eagerly
- To truly be lazy there can be nothing that depends on them
- Lazy beans can be specified as lazy, but the ApplicationContext reserves the right to ignore

#### 1.2.1.2 Phase Completed

- Bean pointer is still referenced in BeanFactory
- Objects have been constructed [ Not ready to use]
- Not available for use yet

### 1.2.2 Setters

#### 1.2.2.1 Post Initialization Dependency Injection ->[ Should only be done on optional beans or dynamic beans]

- After all beans have been instantiated
- Setters are called
- Autowiring occurs(non-constructor based)
- JavaConfig behaves differently

#### 1.2.2.2 Phase Completed

- Beans are fully initialized
- All initial dependencies are injected
- Beans still not ready for use

### 1.2.3 Init: Bean Post Processing

- Final point of configuration manipulation
- Each bean may have additional behaviors added
- Two types of extensible and generic processing; Before and After initializer

### 1.2.4 Initializer

- Second Bean Post Processor action
- Special case
- @PostConstruct method called here
- Framework provides many of these

### 1.2.5 BeanPostProcessor Interface

- BeanPostProcessor interface allows you to inject common behavior to a 'class' of beans
- Still operates on specific beans
- Types: before and after
- Framework leverages lots of these

#### 1.2.6 Phase Completed

- Beans have been instantiated and initialized
- Dependencies have been injected
- Beans are finally ready for use

## 2.Use Phase

- Most of the time is spent in this phase
- ApplicationContext serves proxies to the original class
- ApplicationContext maintains handle to each bean (singleton)

### Context Aware Bean

- Spring provides interface ApplicationContextAware
- Gives your class a handle to the ApplicationContext
- Not a very common interface to use, but is available during the use phase

## 3.Destruction Phase

- Begins when close is called on ApplicationContext
- Any @PreDestroy method is called
- Beans are not destroyed

## Caveats!

- Context cannot be reused again
- Prototype beans are not impacted
- Only garbage collection actually destroys bean instances