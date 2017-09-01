import Alt from 'bases/Alt.js';

class TestAction {
  initTest(value) {
    return value;
  }

  getMoreData() {
    return null;
  }

  test() {
    return null;
  }
}

export default Alt.createActions(TestAction);
