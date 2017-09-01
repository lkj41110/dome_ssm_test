import xFetch from 'services/xFetch';
import Alt from 'bases/Alt.js';
import TestAction from 'actions/TestAction.js';

class TestStore{
	constructor(){
		this.bindListeners({
			handleInitTest: TestAction.initTest,
      handleGetMoreData: TestAction.getMoreData,
      handleTest: TestAction.test,
		});
		this.state={
			testState:'hello test',
      dataList:[
        {
          key: '2',
          name: 'John Brown1',
          age: 32,
          address: 'New York No. 1 Lake Park',
        }]
		}
	}

	handleInitTest = (value)=>{
      let dataList = this.state.dataList;
      let size = dataList.length + 1;
      dataList.push(
      {
        key: size + '',
      name: 'John Brown' + size,
      age: 32 + size,
      address: 'New York No. '+value+' Lake Park',
      });
      this.setState({dataList: dataList});
	}

  handleGetMoreData = () => {
    let dataList = this.state.dataList;
    let size = dataList.length + 1;
    dataList.push(
      {
        key: size + '',
        name: 'John Brown' + size,
        age: 32 + size,
        address: 'New York No. 1 Lake Park',
      }
    );
    this.setState({dataList: dataList});
  }

  handleTest = () => {
    xFetch(SERVER_URL + '/main_test/test').then(result => {
      if (result.success) {
        console.info(result);
      }
    });
  }

}

export default Alt.createStore(TestStore,'TestStore');
