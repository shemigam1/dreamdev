import { useGetAllProductsQuery } from "../apis/fakeStoreAppi";
import { Link } from "react-router";

function Products() {
  const { data, isError, isLoading } = useGetAllProductsQuery();
  //   console.log(response.data);

  return (
    <div className="text-black grid grid-cols-4 gap-4">
      {data?.map((product: any) => (
        <Link to={`/product/${product.id}`}>
          <div className="border border-gray-300 p-4" key={product.id}>
            <img src={product.image} alt={product.title} />
            <h2>{product.title}</h2>
            <p>{product.description}</p>
            <p>&#8358;{product.price}</p>
          </div>
        </Link>
      ))}
    </div>
  );
}

export default Products;
