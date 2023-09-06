/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let cnt = init;
       function increment(){
            return ++cnt;
        }
        function reset(){
            return cnt = init;
        }
        function decrement(){
            return --cnt;
        }
    return {increment, reset, decrement};
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */