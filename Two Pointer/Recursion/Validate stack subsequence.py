class Solution:
    def validateStackSequences(self, pushed, popped):

        def solve(pushIndex, popIndex, stack):

            # All elements popped successfully
            if popIndex == len(popped):
                return True

            # Option 1: Push next element
            if pushIndex < len(pushed):
                stack.append(pushed[pushIndex])

                if solve(pushIndex + 1, popIndex, stack):
                    return True

                stack.pop()      # Backtrack

            # Option 2: Pop if possible
            if stack and stack[-1] == popped[popIndex]:

                x = stack.pop()

                if solve(pushIndex, popIndex + 1, stack):
                    return True

                stack.append(x)      # Backtrack

            return False

        return solve(0, 0, [])