class Solution:
    def isCircularSentence(self, sentence: str) -> bool:
        l=len(sentence)
        if sentence[0]!=sentence[l-1]:
            return False
        for i in range(1,l-1):
            if sentence[i]==' ':
                if sentence[i-1]!=sentence[i+1]:
                    return False
        return True