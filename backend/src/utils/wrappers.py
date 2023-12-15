import time

def timer(func):
  def wrapper(*args, **kwargs):
    print("+ Saídas:")
    start = time.perf_counter()
    func(*args, **kwargs)
    end = time.perf_counter()
    print(f"\n+ Tempo de Execução - {func.__name__} : {round(end-start, 2)} secs")
  return wrapper