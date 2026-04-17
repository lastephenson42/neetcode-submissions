class Solution {
    /**
     * @param {string} s
     * @param {string} t
     * @return {boolean}
     */
    isAnagram(s, t) {

        console.log(s.split('').sort().join(''));

        return s.split('').sort().join('') === t.split('').sort().join('');

    }
}
