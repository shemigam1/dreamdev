import React from "react";
import { useGetProductByIdQuery } from "../apis/fakeStoreAppi";
import { useParams } from "react-router";

function GetProduct() {
  const { id } = useParams();
  const { data } = useGetProductByIdQuery(id);
  return (
    <div>
      {data && (
        <div className="border border-gray-300 p-4" key={data.id}>
          <img src={data.image} alt={data.title} />
          <h2>{data.title}</h2>
          <p>{data.description}</p>
          <p>&#8358;{data.price}</p>
        </div>
      )}

      {!data && (
        <div className="border border-gray-300 p-4">
          <p>product not found</p>
        </div>
      )}
    </div>
  );
}

export default GetProduct;
