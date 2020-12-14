import React from "react";
import axios from 'axios';


export default class TestLoop extends React.Component {

    state = {
        info: {},
        loading: true
    };

    componentDidMount() {
        axios.get("http://localhost:8888/api/subcategories").then(res => {
            const info = res.data;
            const parsedInfo = {
                ...info,
                subcats: Object.entries(info.subcats).reduce((obj, [k, v]) => {
                    obj[k] = "" + v;
                    return obj;
                }, {})
            };

            this.setState({ info: parsedInfo, loading: false });
        });
    }

    render() {
        const { loading, info } = this.state;
        if (loading) {
            return <div>Loading</div>;
        } else {
            return (
                <div>
                    <div>Hi</div>
                    <div>{info.subcats.name}</div>
                </div>
            );
        }
    }
}


/*
*
*
*
* {
  "firstname": "Jessica",
  "lastname": "Wood",
  "favorite": {
        "movie": Flint Town,
        "drink": Sprite
  }
}
*
*
*
*                   <div>{info.favorite.movie}</div>
                    <div>{info.favorite.drink}</div>
* */