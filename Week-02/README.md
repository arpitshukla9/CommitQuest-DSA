# Week 02 — DSA Problems

Three classic interview problems with clean, readable solutions.

---

## Problems

| # | Problem | Difficulty | Key Concept |
|---|---------|------------|-------------|
| 1 | Step Words Finder | Medium | Frequency Map + Anagram |
| 2 | Smallest Non-Representable Sum | Medium | Greedy |
| 3 | LCS of Three Strings | Medium | 3D Dynamic Programming |

---

## Problem Details

### 1. Step Words Finder  
**What:** Given a base word and a list of words, count how many can be formed by adding one letter and rearranging  
**How:** Frequency map comparison with one extra character  
**Time:** O(N × K), **Space:** O(1)

### 2. Smallest Non-Representable Sum  
**What:** Find the smallest sum that cannot be formed using any subset of given coins  
**How:** Greedily accumulate sums, break when coin > current sum + 1  
**Time:** O(n), **Space:** O(1)

### 3. LCS of Three Strings  
**What:** Find the length of the longest common subsequence among three strings  
**How:** Use 3D DP table: dp[i][j][k] = LCS till i,j,k  
**Time:** O(n³), **Space:** O(n³)

---

## Files

Week-02/
├── StepWordsFinder.java
├── SmallestNonRepresentableSum.java
├── LCS.java
└── README.md


---

## Code Style

- Single class per problem  
- Static methods for simplicity  
- Clear variable names  
- Minimal but helpful comments  
- Interview-ready format

---

> Keep coding, keep learning! 🚀