class StockSpanner:

    def __init__(self):
        # Stack to store pairs of (price, span)
        # "infinity" price 
        self.stack = [(float('inf'), 0)]

    def next(self, price: int) -> int:
        span = 1
        
        
        while self.stack[-1][0] <= price:
            # Pop it and update span 
            p, s = self.stack.pop()
            span += s
            
        # Push today's price and total span 
        self.stack.append((price, span))
        
        return span